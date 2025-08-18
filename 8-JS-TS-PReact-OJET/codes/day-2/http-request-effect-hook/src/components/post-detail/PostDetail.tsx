import { useEffect, useState } from "react"
import type { Post } from "../../models/post"
import { getPostById } from "../../services/postservice"

type PostDetailPropType = {
    id: number
}
const PostDetail = (props: PostDetailPropType) => {

    const [post, setPost] = useState<Post | undefined>(undefined)
    const [isLoadingOver, setIsLoadingOver] = useState(false)
    const [errInfo, setErrorInfo] = useState('')

    const fetchPost = async (postId: number) => {
        try {
            const response = await getPostById(postId);
            if (response.status === 200) {
                setPost(response.data)
                setErrorInfo('')
                setIsLoadingOver(true);
            } else {
                setPost(undefined)
                setErrorInfo('could not get post data')
                setIsLoadingOver(true);
            }
        } catch (error: any) {
            setPost(undefined)
            setErrorInfo(error.message)
            setIsLoadingOver(true);
        }
    }

    useEffect(
        () => {
            fetchPost(props.id);
        },
        [props.id]
    )

    let design;
    if (!isLoadingOver) {
        design = <span>Loading...please wait</span>;
    } else if (errInfo !== '') {
        design = <span>{errInfo}</span>
    } else if (post === undefined) {
        design = <span>no post found</span>
    } else {
        design = (
            <div>
                <span>{post.id}:{post.title} posted by user: {post.userId}</span>
                <br />
                <span>{post.body}</span>
            </div>
        )
    }

    return design
}

export default PostDetail