import "../static/css/Custom_nav.scss";
import CustomNav from "./CustomNav.js";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Category } from "../admin/Category.js";
import { User } from "../admin/User.js";
import { Product } from "../admin/Product.js";
import { Tag } from "../admin/Tag.js";
import { Voucher } from "../admin/Voucher.js";
import { Address } from "../admin/Address.js";
import { CustomNavAdmin } from "./CustomNavAdmin.js";
export const Admin = () => {
    return (

    

            // <CustomNav
            //     li={[
            //         ["category", "img/category.svg"],
            //         ["product", "img/product.svg"],
            //         ["tag", "img/tag.svg"],
            //         ["address", "img/address.svg"],
            //         ["voucher", "img/voucher.svg"]
            //     ]}
            // />
            <CustomNavAdmin
                    li={[
                    ["category", "img/category.svg"],
                    ["product", "img/product.svg"],
                    ["tag", "img/tag.svg"],
                    ["address", "img/address.svg"],
                    ["voucher", "img/voucher.svg"]
                ]}
            
            />
         
    )
}