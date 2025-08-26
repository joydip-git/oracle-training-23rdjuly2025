import { h } from "preact";
import router from "../../routes/router";
// import { useState } from "preact/hooks";
// import ArrayDataProvider from "ojs/ojarraydataprovider";

// type Route = {
//     path: string;
//     detail: object;
// };

// type DashBoardPropType = Readonly<{
//     page?: string;
//     routes: Array<object>;
//     onPageChanged: (value: string) => void;
// }>

//const DashBoard = ({ page, routes, onPageChanged }: DashBoardPropType) => {

// const [selectedPage, setSelectedPage] = useState<string>(
//     page ? page : "home"
// );

// const routesDP = new ArrayDataProvider(routes.slice(1), {
//     keyAttributes: "path",
// });
const DashBoard = () => {
    return (
        <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">post management system</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link active" onClick={() => {
                                router.go({ path: 'home' });
                            }}>Home
                                <span class="visually-hidden">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" onClick={() => {
                                router.go({ path: 'posts' });
                            }}>Posts</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" onClick={() => {
                                router.go({ path: 'posts/add' });
                            }}>Add Post</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-sm-2" type="search" placeholder="Search" />
                        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search Posts</button>
                    </form>
                </div>
            </div>
        </nav>
    )
}

export default DashBoard