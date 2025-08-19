/**
 * @license
 * Copyright (c) 2014, 2025, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import { h } from "preact";
import Header from "../header/index";
import Counter from "../counter/index";
import NameList from "../name-list/index";

export function Content() {
  return (
    <div class="oj-web-applayout-max-width oj-web-applayout-content">
      <Header />
      <br />
      <p>OJET is built at the top of Preact and VDOM concept</p>
      <br />
      <Counter />
      <br />
      <br />
      <div>
        <NameList />
      </div>
    </div>
  );
};
