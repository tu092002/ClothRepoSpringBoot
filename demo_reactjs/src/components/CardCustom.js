import React,{ useState } from "react";
import "../static/css/card.css";

export const CardCustom  = () => {
    const [selectedOption, setSelectedOption] = useState('');


    const handleSelectChange = (event) => {
      setSelectedOption(event.target.value);
    };
    return (
        <div className="card">
            <div className="card-img">
                <img width={"350px"} src="https://media2.coolmate.me/cdn-cgi/image/width=672,height=990,quality=85,format=auto/uploads/October2023/CM006.thumb1.3_35.jpg" alt="card-img" />

            </div>
            <div className="card-contain">
                <div className="card-optionColor">
                    <select id="myDropdown" value={selectedOption} onChange={handleSelectChange}>
                        <option value="">Select an option</option>
                        <option value="option1">Option 1</option>
                        <option value="option2">Option 2</option>
                        <option value="option3">Option 3</option>
                    </select>

                </div>

                <h3 className="card-title">Quần kaki</h3>
                <h4 className="card-title">Đen wash</h4>
                <p className="card-price">499.000đ</p>
                <p className="card-voucher">Mua 2 giảm 50 % Freeship toàn quốc</p>
            </div>
        </div>
    )

}