import {  useState } from "react";
import axios from "axios";

function Register() {
  
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");


    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/register", {
          firstName: firstName,
          lastName: lastName,
          login: login,
          password: password,
          });
          alert("User Registation Successfully");

        } catch (err) {
          alert(err);
        }
      }
  
    return (
    <div>
    <div class="container mt-4" >
    <div class="card">
            <h1>Student Registation</h1>
    
    <form>
        <div class="form-group">
          <label>firstName</label>
          <input type="text"  class="form-control" id="firstName" placeholder="Enter FirstName"
          
          value={firstName}
          onChange={(event) => {
            setFirstName(event.target.value);
          }}
          />

        </div>

        <div class="form-group">
          <label>lastName</label>
          <input type="text"  class="form-control" id="lastName" placeholder="Enter LastName"
          
          value={lastName}
          onChange={(event) => {
            setLastName(event.target.value);
          }}
          
          />
 
        </div>
        <div class="form-group">
        <label>login</label>
        <input type="text"  class="form-control" id="login" placeholder="Enter Login"
        
        value={login}
        onChange={(event) => {
          setLogin(event.target.value);
        }}
        
        />

      </div>

        <div class="form-group">
            <label>password</label>
            <input type="password"  class="form-control" id="password" placeholder="Enter password"
            
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            
            />
          </div>
        <button type="submit" class="btn btn-primary mt-4" onClick={save} >Save</button>
       
      </form>
    </div>
    </div>
     </div>
    );
  }
  
  export default Register;