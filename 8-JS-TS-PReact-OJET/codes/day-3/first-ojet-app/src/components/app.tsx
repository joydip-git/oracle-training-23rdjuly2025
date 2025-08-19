/**
 * @license
 * Copyright (c) 2014, 2025, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import { registerCustomElement } from "ojs/ojvcomponent";
import { h } from "preact";
import { useEffect } from "preact/hooks";
import Context = require("ojs/ojcontext");
import { Content } from "./content/index";

export const App = registerCustomElement(
  "app-root",
  () => {
    useEffect(() => {
      Context
        .getPageContext()
        .getBusyContext()
        .applicationBootstrapComplete();
    }, []);

    return (
      <div id="appContainer" class="oj-web-applayout-page">
        <Content />
      </div>
    );
  }
);
