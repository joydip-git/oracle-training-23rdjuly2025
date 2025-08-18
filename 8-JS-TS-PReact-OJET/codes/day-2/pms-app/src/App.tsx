import DashBoard from './components/dash-board/DashBoard'
import ProductList from './components/product-list/ProductList'

function App() {
  return (
    <>
      <DashBoard />
      <br />
      <div className='container container-fluid'>
        <ProductList />
      </div>
    </>
  )
}

export default App
