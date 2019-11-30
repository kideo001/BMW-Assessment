import axios from 'axios'

export default  {
    getData() {
        return axios.get("http://localhost:8080/data");
    }
}