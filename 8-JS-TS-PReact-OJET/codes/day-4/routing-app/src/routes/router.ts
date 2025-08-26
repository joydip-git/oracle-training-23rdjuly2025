import Router, { DetailedRouteConfig, RedirectedRouteConfig } from "ojs/ojcorerouter";
import { urlParamAdapter } from "ojs/ojrouter";
import UrlPathAdapter from "ojs/ojurlpathadapter";
import 'preact'

type Route = {
    path: string;
    detail?: object;
    redirect?: string;
};

const routes: Array<Route> = [
    {
        path: "",
        redirect: "home",
    },
    {
        path: "home",
        detail: {
            label: "Home",
            iconClass: "oj-navigationlist-item-icon"
        }
    },
    {
        path: "posts",
        detail: {
            label: "PostList",
            iconClass: "oj-navigationlist-item-icon"
        }
    },
    {
        path: "posts/view/:id",
        detail: {
            label: "PostDetail",
            iconClass: "oj-navigationlist-item-icon"
        }
    },
    {
        path: "posts/update/:id",
        detail: {
            label: "UpdatePost",
            iconClass: "oj-navigationlist-item-icon"
        }
    },
    {
        path: "posts/add",
        detail: {
            label: "AddPost",
            iconClass: "oj-navigationlist-item-icon"
        }
    }
]

const router = new Router<DetailedRouteConfig>(routes, {
    urlAdapter: new UrlPathAdapter(),
});

router.sync();

export default router;