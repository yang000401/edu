import axios from "axios";

const client = axios.create({
  baseURL: "",
  withCredentials: true,
  responseType: "json",
});

export default client;
