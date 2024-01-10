import React from "react";
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Carousel from 'react-bootstrap/Carousel';

export const Header = () => {
    const customStyle = {
        color: 'white', // Màu chữ mong muốn
      };
    return (
        <Navbar expand="lg" style={{background:"black"}}>
            <Container>

                <Navbar.Brand href="/">
                    <img width={"80px"} src="data:image/jpeg;base64,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" />


                </Navbar.Brand>

                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                        
                    >
                        <Nav.Link href="/login" style={customStyle}>Login</Nav.Link>
                        <Nav.Link href="/register" style={customStyle}>Register</Nav.Link>
                        <Nav.Link href="/detail" style={customStyle}>Detail</Nav.Link>
                        <NavDropdown title="Link"  id="navbarScrollingDropdown">
                            <NavDropdown.Item href="/detail"  style={customStyle}>Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action4">
                                Another action
                            </NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action5">
                                Something else here
                                
                            </NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link href="#" disabled  style={customStyle}>
                            Link 
                        </Nav.Link>
                    </Nav>
                    <Form className="d-flex">
                        <Form.Control
                            type="search"
                            placeholder="Search"
                            className="me-2"
                            aria-label="Search"
                        />
                        <Button variant="outline-success"  style={customStyle}>Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Container>
        </Navbar>

    )




}