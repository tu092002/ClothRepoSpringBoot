import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Footer } from "./layout/Footer";
import { Header } from "./layout/Header";
import { Info } from "./components/Info";
import {createContext,Fragment, useReducer} from "react";
import { Home } from "./components/Home";
import Register from './components/Register';
import Login from './components/Login';
import MyUserReducer from './reducers/MyUserReducer';
import cookie from "react-cookies";
import React from 'react';
import { Detail } from './components/Detail';
import { Admin } from './components/Admin';
import CustomNav from './components/CustomNav';


export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);


  return (
    <React.Fragment>
      <MyUserContext.Provider value={[user, dispatch]}>

        <BrowserRouter>
          <Header/>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/info" element={<Info />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            <Route path="/detail" element={<Detail />} />
            <Route path="/custom" element={<CustomNav/>} />
            <Route path="/admin" element={<Admin/>} />

          </Routes>
          <Footer />
        </BrowserRouter>
      </MyUserContext.Provider>


    </React.Fragment>
  )
}

export default App;
