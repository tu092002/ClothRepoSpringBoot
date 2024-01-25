package com.sergio.jwt.backend.entites;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {
    @NotNull(message = "At least one file must be present")
    @Size(min = 1, message = "At least one file must be present")
    public MultipartFile[] files;

}
