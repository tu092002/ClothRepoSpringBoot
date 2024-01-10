import { useEffect, useState } from "react"
import { Spinner } from "react-bootstrap";
import Carousel from 'react-bootstrap/Carousel';
import { Info } from "./Info";
import { CardCustom } from "./CardCustom";
export const Home = () => {
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        fetch("http://localhost:8080/SpringMVCThueNha1/api/user/")
            .then((res) => res.json())
            .then((data) => {
                setData(data);
                setLoading(false);

            })
            .catch((err) => {
                console.error("Loi khi fetch:", err);
                setLoading(false);
            });
    }, []);
    if (loading) {
        return <Spinner animation="border" role="status">
            <span className="visually-hidden">Loading...</span>
        </Spinner>
    }
    return (


        <div>
            <Carousel data-bs-theme="dark">
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="https://media2.coolmate.me/cdn-cgi/image/width=1920,quality=90,format=auto/uploads/December2023/612LOOKBACK-BANNER.jpg"
                        alt="First slide"
                    />
                    <Carousel.Caption>
                        <h5>First slide label</h5>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="https://media2.coolmate.me/cdn-cgi/image/width=1920,quality=90,format=auto/uploads/December2023/BANNER_WINTER_CLT_(ccmaNdbnn).png"
                        alt="Second slide"
                    />
                    <Carousel.Caption>
                        <h5>Second slide label</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <img
                        className="d-block w-100"
                        src="https://media2.coolmate.me/cdn-cgi/image/width=1920,quality=90,format=auto/uploads/December2023/BANNER_WINTER_CLT_(ccmfnlfnal).png"
                        alt="Third slide"
                    />
                    <Carousel.Caption>
                        <h5>Third slide label</h5>
                        <p>
                            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                        </p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
            
            <div className=" d-flex">
                <CardCustom />
                <CardCustom />
                <CardCustom />
                <CardCustom />
            </div>


        </div>
    )
}