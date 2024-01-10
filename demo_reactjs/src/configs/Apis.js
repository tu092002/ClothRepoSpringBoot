import axios from "axios";
import cookie from "react-cookies";
const SERVER_CONTEXT = "";
const SERVER = "http://localhost:8080";

export const endpoints =  {

    "login": `${SERVER_CONTEXT}/login`,
    "current-user": `${SERVER_CONTEXT}/current-user`,
    "register": `${SERVER_CONTEXT}/register`,
    // "details": (idPost) => `${SERVER_CONTEXT}/api/posts/${idPost}/ `,
    // "comments": (idPost) => `${SERVER_CONTEXT}/api/posts/${idPost}/comments/`,
    // "add-comment": `${SERVER_CONTEXT}/api/comments/`,


}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization": "Bearer "+cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
});