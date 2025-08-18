import Axios, { type AxiosResponse } from 'axios'
import type { Post } from '../models/post'

const API_URL = 'https://jsonplaceholder.typicode.com/posts'

export const getPosts = (): Promise<AxiosResponse<Post[]>> => {
    return Axios.get<Post[]>(API_URL)
}

export const getPostById = (id: number): Promise<AxiosResponse<Post>> => {
    return Axios.get<Post>(`${API_URL}/${id}`)
}