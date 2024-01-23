package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.entites.Image;
import com.sergio.jwt.backend.entites.Product;
import com.sergio.jwt.backend.exceptions.NotFoundException;
import com.sergio.jwt.backend.repositories.ImageRepository;
import com.sergio.jwt.backend.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class    ImageService {
    @Autowired
    private  ImageRepository imageRepository;
    private final FileUtils fileUtils;
    @Autowired
    ProductService productService;
    public List<Image> findImagesByProductId(int id){
        return imageRepository.findImagesByProductId(id);
    }

    public List<Image> getAllImage() {
        return imageRepository.findByOrderByCreatedAtDesc();
    }

    public Image getImage(Integer id) {
        return imageRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found image with id = " + id, HttpStatus.NOT_FOUND);
        });
    }

    public Image uploadImage(MultipartFile file, Product p, int idImgUpdate) {
        fileUtils.validateFile(file);

        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            // nén giảm hình ảnh
            byte[] compressedImageBytes = compressImage(file);


            Image image = new Image(idImgUpdate,fileName, file.getContentType(), compressedImageBytes,p);
            return imageRepository.save(image);
        } catch (Exception e) {
            throw new RuntimeException("Upload image error: " + e.getMessage());
        }
    }

    public void deleteImage(Integer id) {
        Image image = imageRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found image with id = " + id, HttpStatus.NOT_FOUND);
        });

        imageRepository.delete(image);
    }
    private byte[] compressImage(MultipartFile file) throws IOException {
        BufferedImage originalImage = ImageIO.read(file.getInputStream());
        BufferedImage imageWithoutAlpha = removeAlphaChannel(originalImage);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(imageWithoutAlpha, "jpg", baos);
        return baos.toByteArray();
    }
    private static BufferedImage removeAlphaChannel(BufferedImage img) {
        if (!img.getColorModel().hasAlpha()) {
            return img;
        }

        BufferedImage target = createImage(img.getWidth(), img.getHeight(), false);
        Graphics2D g = target.createGraphics();
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.drawImage(img, 0, 0, null);
        g.dispose();

        return target;
    }

    private static BufferedImage createImage(int width, int height, boolean hasAlpha) {
        return new BufferedImage(width, height, hasAlpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
    }
}