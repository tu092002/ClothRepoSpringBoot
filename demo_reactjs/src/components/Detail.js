import { useState } from "react";
import Star from "./Star";
import { Container, Row, Col } from 'react-grid-system';
import { Tabs, TabList, Tab, TabPanel } from 'react-tabs';

export const Detail = () => {
    const [selectedStars, setSelectedStars] = useState(0);
    const [activeTabColor, setActiveTabColor] = useState(0);
    const [activeTabSize, setActiveTabSize] = useState(0);
    const changeTabColor = (index) => {
        setActiveTabColor(index);
    }
    const changeTabSize = (index) => {
        setActiveTabSize(index);
    }
    return (
        <Container className="detail-section container">
            <Row justify="center">
                <Col sm={6}>
                    <div className="img-product" width={"200px"}>
                        <img width={"100%"} src="https://media2.coolmate.me/cdn-cgi/image/quality=80,format=auto/uploads/July2022/da_troi_fix_1.jpg" alt="img" />
                    </div>
                </Col>
                <Col sm={6}>
                    <div className="info-product">
                        <h1>T-Shirt thể thao Basics</h1>
                        <span className="d-block">
                            {Array(5)
                                .fill()
                                .map((_, index) => (
                                    <Star
                                        key={index}
                                        filled={index < selectedStars}
                                        onClick={() => setSelectedStars(index + 1)} />
                                ))}
                        </span>

                        <p className="price">99.000đ</p>

                    </div>
                    <div className="product-color">
                        {activeTabColor === 0 && <div>Đen</div>}
                        {activeTabColor === 1 && <div>Xám</div>}
                        {activeTabColor === 2 && <div>Xanh</div>}
                        <button className="bg-black" style={{ width: "40px", height: "20px" }} onClick={() => changeTabColor(0)}></button>
                        <button className="bg-gray" style={{ width: "40px", height: "20px" }} onClick={() => changeTabColor(1)}></button>
                        <button className="bg-primary" style={{ width: "40px", height: "20px" }} onClick={() => changeTabColor(2)}></button>


                    </div>

                    <div className="product-size">
                        {activeTabSize === 0 && <div>S</div>}
                        {activeTabSize === 1 && <div>M</div>}
                        {activeTabSize === 2 && <div>L</div>}
                        {activeTabSize === 3 && <div>XL</div>}
                        {activeTabSize === 4 && <div>2XL</div>}
                        <button style={{ width: "40px", height: "20px" }} onClick={() => changeTabSize(0)}></button>
                        <button style={{ width: "40px", height: "20px" }} onClick={() => changeTabSize(1)}></button>
                        <button style={{ width: "40px", height: "20px" }} onClick={() => changeTabSize(2)}></button>
                        <button style={{ width: "40px", height: "20px" }} onClick={() => changeTabSize(3)}></button>
                        <button style={{ width: "40px", height: "20px" }} onClick={() => changeTabSize(4)}></button>


                    </div>

                    <br />
                    <br />

                    <div className="total-product d-flex">

                        <div class="quantity-product"><a href="#" class="quantity__reduce">-</a> <input type="number" value="1" max="109" min="1" class="quantity__control" /> <a href="#" class="quantity__augure">+</a></div>
                        <div className="add-card">
                            <button>
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5M3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4m7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4m-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2m7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2"></path>
                                </svg>
                                Thêm vào giỏ hàng</button>
                        </div>
                    </div>
                </Col>


            </Row>

        </Container>
    )
}