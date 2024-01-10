import React, { useState } from "react";
import { Link } from "react-router-dom";
const CustomNav = ({ li }) => {
  const [window, setWindow] = useState(false);
  const [activeTab, setActiveTab] = useState("category");
  // useEffect(() => {

  // }, [active]);
  let openClose = () => {
    if (window === false) {
      setWindow(true);
    } else {
      setWindow(false);
    }
  };
  return (
    <div className="d-flex">
    <nav className="navbar-menu" style={{ width: window === false ? 250 : 60 }}>

      <div className="burger" onClick={() => openClose()}>
        <img src="img/menu.svg" alt="burger" />
      </div>
      <ul className="navbar__list">
        {li.map((item, i) => (
          <div>
              <TabNavItemAdmin title={item[0]} id={item[0]} activeTab={activeTab} setActiveTab={setActiveTab} item={item} window={window}/>
             
         </div>
        ))}
        
       
      </ul>
      
      
    </nav>
   
      <div className="content">
      <TabContent id="category" activeTab={activeTab}>
                <FirstTab/>
              </TabContent>
              <TabContent id="product" activeTab={activeTab}>
                <SecondTab/>
              </TabContent>
      </div>
    </div>  

      );
};
 const FirstTab = () => <p>This is Tab 1 content.</p>;
 const SecondTab = () => <p>This is Tab 2 content.</p>;
 // Định nghĩa TabContent
 const TabContent = ({ id, activeTab, children }) => {
  return activeTab == id ? <div>{children}</div> : null;
 };
//Định nghĩa tab admin
const TabNavItemAdmin = ({title, id, activeTab, setActiveTab, item, window}) => {
  const sukien = () => {
    console.log(activeTab)
  }
  return (
    <div  key={id}   onClick={() => { setActiveTab(id);sukien()}}
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
export default CustomNav;
// import React, { useState } from "react";

// const CustomNav = () => {
//   const [activeTab, setActiveTab] = useState("tab1");

//   return (
//     <div className="Tabs">
//       <ul className="nav">
//         <TabNavItem title="Tab 1" id="tab1" activeTab={activeTab} setActiveTab={setActiveTab}/>
//         <TabNavItem title="Tab 2" id="tab2" activeTab={activeTab} setActiveTab={setActiveTab}/>
//       </ul>

//       <div className="outlet">
//         <TabContent id="tab1" activeTab={activeTab}>
//           <FirstTab/>
//         </TabContent>
//         <TabContent id="tab2" activeTab={activeTab}>
//           <SecondTab/>
//         </TabContent>
//       </div>
//     </div>
//   );
// };

// // Định nghĩa TabNavItem
// const TabNavItem = ({ title, id, activeTab, setActiveTab }) => {
//   return (
//     <li
//       onClick={() => setActiveTab(id)}
//       className={activeTab === id ? "active" : ""}
//     >
//       {title}
//     </li>
    
//   );
//  };
 
//  // Định nghĩa TabContent
//  const TabContent = ({ id, activeTab, children }) => {
//   return activeTab === id ? <div>{children}</div> : null;
//  };
 
//  // Định nghĩa FirstTab và SecondTab
//  const FirstTab = () => <p>This is Tab 1 content.</p>;
//  const SecondTab = () => <p>This is Tab 2 content.</p>;
 
// export default CustomNav;
