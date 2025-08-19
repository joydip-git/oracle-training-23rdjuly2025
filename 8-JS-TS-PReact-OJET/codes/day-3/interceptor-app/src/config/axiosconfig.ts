import Axios from 'axios'

const axiosInstance = Axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com/',
    timeout: 5000,
    timeoutErrorMessage: 'request timed out'
});

const intercetorManager = axiosInstance.interceptors;
intercetorManager
    .request
    .use(
        (requestObject) => {
            requestObject.headers.set('Authorization', 'beaer token')
            return requestObject
        },
        () => Promise.reject()
    );

export default axiosInstance