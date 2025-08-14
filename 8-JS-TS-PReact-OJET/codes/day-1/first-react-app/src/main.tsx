import { createRoot, type Root } from "react-dom/client";
import App from "./App";

const div = document.getElementById('root') as HTMLDivElement;
const rootElement: Root = createRoot(div);
rootElement.render(<App />)
//const appDesign = App();
//const appDesign2 = App();
//rootElement.render(appDesign)
// setTimeout(
//   () => rootElement.render(appDesign),
// 5000
// )