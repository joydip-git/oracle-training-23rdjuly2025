import { render } from 'preact'
import './index.css'
import { App } from './app.tsx'
//import { createRoot } from 'preact/compat/client'

render(<App />, document.getElementById('app')!)

// const root = createRoot(document.getElementById('app') as HTMLElement)
// root.render(<App />)
