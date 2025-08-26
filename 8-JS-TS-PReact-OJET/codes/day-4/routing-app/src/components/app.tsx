/**
 * @license
 * Copyright (c) 2014, 2025, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import { registerCustomElement, Root } from "ojs/ojvcomponent";
import { h } from "preact";
import { useEffect, useState } from "preact/hooks";
import Context from "ojs/ojcontext";
import DashBoard from "./dash-board/index";
import router from "../routes/router";
import { lazy } from "preact/compat";
import { ActionableState, DetailedRouteConfig, RedirectedRouteConfig } from "ojs/ojcorerouter";
import { Content } from "./content/index";

const Home = lazy(() => import("./home/index"));
const PostList = lazy(() => import("./post-list/index"));
const PostDetail = lazy(() => import("./post-detail/index"));
const AddPost = lazy(() => import("./add-post/index"));
const UpdatePost = lazy(() => import("./update-post/index"));

//@Root()
export const App = registerCustomElement(
  "app-root",
  () => {
    console.log('in app');

    const [routePath, setRoutePath] = useState<string>("");

    useEffect(() => {
      Context
        .getPageContext()
        .getBusyContext()
        .applicationBootstrapComplete();

      router.currentState.subscribe(
        (actionable: ActionableState<DetailedRouteConfig | RedirectedRouteConfig>) => {
          const newPath = actionable.state?.path;
          setRoutePath(newPath);
        }
      )
    }, []);

    return (
      <div>
        <DashBoard />
        <main>
          {
            routePath === "home" && <Home />
          }
        </main>
      </div>)
  }
);
