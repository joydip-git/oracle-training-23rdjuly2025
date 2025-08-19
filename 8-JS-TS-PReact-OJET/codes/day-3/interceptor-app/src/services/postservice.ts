//import Axios, { type AxiosResponse } from 'axios'
import axiosInstance from '../config/axiosconfig'
import type { Post } from '../models/post'

//const API_URL = 'https://jsonplaceholder.typicode.com/posts'

export const getPosts = (): Promise<AxiosResponse<Post[]>> => {
    //return Axios.get<Post[]>(API_URL)
    return axiosInstance.get<Post[]>('posts')
}

export const getPostById = (id: number): Promise<AxiosResponse<Post>> => {
    //return Axios.get<Post>(`${API_URL}/${id}`)
    return axiosInstance.get<Post>(`posts/${id}`)
}