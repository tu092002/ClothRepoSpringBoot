import React from 'react';
import { useEffect, useState } from "react"
import { Spinner } from "react-bootstrap";
import { MDBFooter, MDBContainer, MDBRow, MDBCol, MDBIcon } from 'mdb-react-ui-kit';

export const Footer = () => {

    return (
        <MDBFooter bgColor='light' className='text-center text-lg-start text-muted'>
            
            <section className='d-flex justify-content-center justify-content-lg-between p-4 border-bottom'>
                <div className='me-5 d-none d-lg-block'>
                    <span>Get connected with us on social networks:</span>
                </div>

                <div>
                    <a href='' className='me-4 text-reset'>
                        <MDBIcon fab icon="facebook-f" />
                    </a>
                    <a href='' className='me-4 text-reset'>
                        <MDBIcon fab icon="twitter" />
                    </a>
                    <a href='' className='me-4 text-reset'>
                        <MDBIcon fab icon="google" />
                    </a>
                    <a href='' className='me-4 text-reset'>
                        <MDBIcon fab icon="instagram" />
                    </a>
                    <a href='' className='me-4 text-reset'>
                        <MDBIcon fab icon="linkedin" />
                    </a>
                    <a href='' className='me-4 text-reset'>
                        <MDBIcon fab icon="github" />
                    </a>
                </div>
            </section>

            <section className=''>
                <MDBContainer className='text-center text-md-start mt-5'>
                    <MDBRow className='mt-3'>
                        <MDBCol md="3" lg="4" xl="3" className='mx-auto mb-4'>
                            <h6 className='text-uppercase fw-bold mb-4'>
                                <MDBIcon icon="gem" className="me-3" />
                                Company name
                            </h6>
                            <p>
                                Here you can use rows and columns to organize your footer content. Lorem ipsum dolor sit amet,
                                consectetur adipisicing elit.
                            </p>
                        </MDBCol>

                        <MDBCol md="2" lg="2" xl="2" className='mx-auto mb-4'>
                            <h6 className='text-uppercase fw-bold mb-4'>Products</h6>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Angular
                                </a>
                            </p>
                            <p>
                                <a href='#!' className='text-reset'>
                                    React
                                </a>
                            </p>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Vue
                                </a>
                            </p>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Laravel
                                </a>
                            </p>
                        </MDBCol>

                        <MDBCol md="3" lg="2" xl="2" className='mx-auto mb-4'>
                            <h6 className='text-uppercase fw-bold mb-4'>Useful links</h6>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Pricing
                                </a>
                            </p>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Settings
                                </a>
                            </p>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Orders
                                </a>
                            </p>
                            <p>
                                <a href='#!' className='text-reset'>
                                    Help
                                </a>
                            </p>
                        </MDBCol>

                        <MDBCol md="4" lg="3" xl="3" className='mx-auto mb-md-0 mb-4'>
                            <h6 className='text-uppercase fw-bold mb-4'>Contact</h6>
                            <p>
                                <MDBIcon icon="home" className="me-2" />
                                New York, NY 10012, US
                            </p>
                            <p>
                                <MDBIcon icon="envelope" className="me-3" />
                                info@example.com
                            </p>
                            <p>
                                <MDBIcon icon="phone" className="me-3" /> + 01 234 567 88
                            </p>
                            <p>
                                <MDBIcon icon="print" className="me-3" /> + 01 234 567 89
                            </p>
                        </MDBCol>
                    </MDBRow>
                </MDBContainer>
            </section>

            <div className='text-center p-4' style={{ backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
                © 2021 Copyright:
                <a className='text-reset fw-bold' href='https://mdbootstrap.com/'>
                    MDBootstrap.com
                </a>
            </div>


        </MDBFooter>

        // <footer class="site-footer mobile--hidden"><div class="container"><div class="site-footer__inner"><div class="site-footer__sidebar"><div><h4 class="site-footer__title">
        //     COOLMATE lắng nghe bạn!
        // </h4> <p class="site-footer__description" style="margin-bottom: 30px;">
        //         Chúng tôi luôn trân trọng và mong đợi nhận được mọi ý kiến đóng góp từ
        //         khách hàng để có thể nâng cấp trải nghiệm dịch vụ và sản phẩm tốt hơn nữa.
        //     </p> <a href="https://form.typeform.com/to/lU2oprGc?typeform-medium=embed-snippet" target="_blank" class="site-footer__btn">
        //         Đóng góp ý kiến
        //     </a></div> <div style="width: 25%;"><div class="footer-info"><div class="footer-info__icon"> <img src='#' alt='logo' /></div> <div class="footer-info__content"><span class="footer-info__title">
        //         Hotline
        //     </span> <p class="footer-info__desciption"><a href="tel: 1900272737">1900.272737</a> - <a href="tel: 02877772737">028.7777.2737</a> <br /> <span>(8:30 - 22:00)</span></p></div></div> <div class="footer-info"><div class="footer-info__icon"><img src="https://static.coolmate.me/images/footer/icon-email.svg" alt="Footer Icon Email" /></div> <div class="footer-info__content"><span class="footer-info__title">
        //         Email
        //     </span> <p class="footer-info__desciption"><a href="mailto: Cool@coolmate.me">
        //         Cool@coolmate.me
        //     </a></p></div></div></div> <div class="footer-social"><a href="https://www.facebook.com/coolmate.me" target="_blank" class="footer-social__item">
        //         <img src="https://mcdn.coolmate.me/image/June2023/mceclip1_43.png" alt="Footer Icon facebook" /> </a> <a href="https://zalo.me/1517736583279228381" target="_blank" class="footer-social__item"><img src="https://mcdn.coolmate.me/image/June2023/mceclip2_68.png" alt="Footer Icon Zalo" /></a> <a href="https://www.tiktok.com/@cool.coolmate" target="_blank" class="footer-social__item"><img src="https://mcdn.coolmate.me/image/June2023/mceclip0_62.png" alt="Footer Icon tiktok" /></a> <a href="https://www.instagram.com/coolmate.me/" target="_blank" class="footer-social__item"><img src="https://static.coolmate.me/images/footer/icon-instar.svg" alt="Footer Icon instar" /></a> <a href="https://www.youtube.com/channel/UCWw8wLlodKBtEvVt1tTAsMA" target="_blank" class="footer-social__item"><img src="https://static.coolmate.me/images/footer/icon-youtube.svg" alt="Footer Icon youtube" /></a></div></div> <div class="site-footer__menu"><div class="footer-menu"><div class="footer-menu__item"><h4 class="footer-menu__title">COOLCLUB</h4> <ul><li><a href="/page/coolclub-chuong-trinh-khach-hang-than-thiet-cua-coolmate?itm_source=footerm">Đăng kí thành viên</a></li> <li><a href="/page/coolclub-chinh-sach-khach-hang-than-thiet?itm_source=footer">Ưu đãi &amp; Đặc quyền</a></li></ul></div> <div class="footer-menu__item"><h4 class="footer-menu__title">Chính sách</h4> <ul><li><a href="/page/dich-vu-60-ngay-doi-tra">Chính sách đổi trả 60 ngày</a></li> <li><a href="/page/chuong-trinh-va-chinh-sach-khuyen-mai-tai-coolmate">Chính sách khuyến mãi</a></li> <li><a href="/page/chinh-sach-bao-mat-thong-tin-ca-nhan">Chính sách bảo mật</a></li> <li><a href="/page/dich-vu-giao-hang-coolmate">Chính sách giao hàng</a></li></ul> <h4 class="footer-menu__title">Coolmate.me</h4> <ul><li><a href="/page/changelog?itm_source=footer">Lịch sử thay đổi website</a></li></ul></div> <div class="footer-menu__item"><h4 class="footer-menu__title">Chăm sóc khách hàng</h4> <ul><li><a href="/page/11-dich-vu-tai-coolmate-co-the-ban-chua-biet">Trải nghiệm mua sắm 100% hài lòng</a></li> <li><a href="/page/faqs">Hỏi đáp - FAQs</a></li></ul> <h4 class="footer-menu__title">Kiến thức mặc đẹp</h4> <ul><li><a href="/size-chart">Hướng dẫn chọn size</a></li> <li><a href="/blog">Blog</a></li> <li><a href="https://www.facebook.com/groups/2103080403316797" target="_blank">Group mặc đẹp sống chất</a></li></ul></div> <div class="footer-menu__item"><h4 class="footer-menu__title">Tài liệu - Tuyển dụng</h4> <ul><li><a href="/lp/coolmate-101?itm_source=footer#recruitment-jobs">Tuyển dụng</a></li> <li><a href="http://online.gov.vn/(X(1)S(sgmttobbtsiaq3l5itoicxhw))/Home/WebDetails/53184?AspxAutoDetectCookieSupport=1" target="_blank">Đăng ký bản quyền</a></li></ul> <h4 class="footer-menu__title">Về COOLMATE</h4> <ul><li><a href="/lp/coolmate-101?itm_source=footer">Coolmate 101</a></li> <li><a href="/page/11-dich-vu-tai-coolmate-co-the-ban-chua-biet?itm_source=footer">DVKH xuất sắc</a></li> <li><a href="/page/coolmate-story?itm_source=footer"> Câu chuyện về Coolmate</a></li> <li><a href="/page/san-pham-coolmate-duoc-san-xuat-nhu-the-nao?itm_source=footer">Nhà máy</a></li> <li><a href="/collection/care-and-share?itm_source=footer">Care &amp; Share</a></li></ul></div> <div class="footer-menu__item"><h4 class="footer-menu__title">Địa chỉ liên hệ</h4> <p class="footer-menu__desciption"><u>Văn phòng Hà Nội:</u> Tầng 3-4, Tòa nhà BMM, KM2, Đường Phùng Hưng, Phường Phúc La, Quận Hà Đông, TP Hà Nội</p> <p class="footer-menu__desciption"><u>Văn phòng Tp HCM:</u> Lầu 1, Số 163 Trần Trọng Cung, Phường Tân Thuận Đông, Quận 7, Tp. Hồ Chí Minh</p></div></div></div></div> <div class="site-footer__after"><div class="copyright"><h5 class="copyright__title">
        //             @ CÔNG TY TNHH FASTECH ASIA
        //         </h5> <p class="copyright__description">Mã số doanh nghiệp: 0108617038. Giấy chứng nhận đăng ký doanh nghiệp do Sở Kế hoạch và Đầu tư TP Hà Nội cấp lần đầu ngày 20/02/2019.</p></div> <div class="site-footer__logo"><a href="https://tinnhiemmang.vn/danh-ba-tin-nhiem/coolmateme-1646213826" title="Chung nhan Tin Nhiem Mang" target="_blank" style="margin-right: 10px;"><img src="https://media2.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/March2022/handle_cert.png" alt="Chung nhan Tin Nhiem Mang" style="max-height: 40px;" /></a> <a href="https://www.dmca.com/Protection/Status.aspx?ID=c6fdbdee-127c-4cf1-923d-7efe75201df6&amp;refurl=https://www.coolmate.me/?itm_source=navbar" title="DMCA.com Protection Status" target="_blank" class="dmca-badge" style="margin-right: 10px;"><img src="https://media2.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/March2022/dmca_protected_15_120.png" alt="DMCA.com Protection Status" style="max-height: 40px;" /></a> <a href="#" style="margin-right: 10px;"><img src="https://static.coolmate.me/images/footer/Coolmate-info.png" alt="Coolmate info" width="39" height="40" /></a> <a href="http://online.gov.vn/(X(1)S(3e0hkhscv5zs101mhuopx43a))/Home/WebDetails/53184?AspxAutoDetectCookieSupport=1" target="_blank"><img src="https://static.coolmate.me/images/footer/logoSaleNoti.png" alt="Coolmate info" width="106" height="40" /></a></div></div></div>
        // </footer>

    )
}

