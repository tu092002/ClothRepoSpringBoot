import { useState } from 'react';
import { Category } from '../admin/Category';
import { Product } from '../admin/Product';
import { Address } from '../admin/Address';
import { Voucher } from '../admin/Voucher';
import { Tag } from '../admin/Tag';
import { User } from '../admin/User';

// Tạo các component riêng biệt 
export const TabNavItemAdmin = ({ title, id, activeTab, setActiveTab, item, window }) => {
    const sukien = () => {
        console.log(activeTab)
    }
    return (
        <div key={id} onClick={() => { setActiveTab(id); sukien() }}
            className={activeTab == id ? "active navbar__li-box" : "navbar__li-box"} >
            <img
                src={item[1]}
                alt={item[1]}
                style={{ paddingLeft: window === false ? 27 : 17 }}
            />
            <li
                className="navbar__li"
                style={{ display: window === false ? "inline-block" : "none" }}
            >

                <p>{item[0]}</p>
            </li>

        </div>
    )
}
export const CustomNavAdmin = ({li}) =>{
    const [window, setWindow] = useState(false);

    // Theo dõi tab hiện tại
    const [activeTab, setActiveTab] = useState('category');
    let openClose = () => {
        if (window === false) {
            setWindow(true);
        } else {
            setWindow(false);
        }
    };

    return (
        <div className='d-flex'>
            <nav className="navbar-menu" style={{ width: window === false ? 250 : 60 }}>

                <div className="burger" onClick={() => openClose()}>
                    <img src="img/menu.svg" alt="burger" />
                </div>
                <ul className="navbar__list">
                    {li.map((item, i) => (
                        <div>
                            <TabNavItemAdmin title={item[0]} id={item[0]} activeTab={activeTab} setActiveTab={setActiveTab} item={item} window={window} />

                        </div>
                    ))}


                </ul>


            </nav>
            {/* Hiển thị component tương ứng với tab hiện tại */}

            <div className='admin-content'>
                {activeTab === 'category' && <Category />}
                {activeTab === 'product' && <Product />}
                {activeTab === 'address' && <Address />}
                {activeTab === 'tag' && <Tag />}
                {activeTab === 'voucher' && <Voucher />}
                {activeTab === 'user' && <User />}
            </div>x

        </div>
    );
}
