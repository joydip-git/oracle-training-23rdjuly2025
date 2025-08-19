import type { AxiosResponse } from "axios"
import { getPosts } from "../../services/postservice"
import type { Post } from "../../models/post"
import { useEffect, useState } from "react"
import PostDetail from "../post-detail/PostDetail"

const PostList = () => {
    console.log('component loaded...');
    const [posts, setPosts] = useState<Post[]>([])
    const [isLoadingOver, setIsLoadingOver] = useState(false)
    const [errInfo, setErrorInfo] = useState('')
    const [selectedPostId, setSelectedPostId] = useState(0)

    const fetchPosts = async () => {
        try {
            const response: AxiosResponse<Post[]> = await getPosts()
            if (response.status === 200) {
                setPosts(response.data.slice(0, 10))
                setIsLoadingOver(true)
                setErrorInfo('')
            } else {
                setPosts([])
                setIsLoadingOver(true)
                setErrorInfo('did not get posts')
            }
        } catch (e: any) {
            setPosts([])
            setIsLoadingOver(true)
            setErrorInfo('did not get posts beacause ' + e.message)
        }
    }

    useEffect(
        () => {
            fetchPosts()
        },
        []
    )

    let design;
    if (!isLoadingOver) {
        design = <span>Loading...please wait</span>;
    } else if (errInfo !== '') {
        design = <span>{errInfo}</span>
    } else if (posts.length === 0) {
        design = <span>no posts found</span>
    } else {
        design = (
            <ul>
                {
                    posts.map(
                        (p) => {
                            return <li onClick={
                                () => {
                                    setSelectedPostId(p.id)
                                }
                            }>
                                <u>{p.title}</u>
                            </li>
                        }
                    )
                }
            </ul>
        )
    }
    return (
        <div>
            {

                design
            }
            <br />
            <br />
            {
                selectedPostId > 0 ? <PostDetail id={selectedPostId} /> : <span>select a post to view</span>
            }
        </div>
    )
}

export default PostList