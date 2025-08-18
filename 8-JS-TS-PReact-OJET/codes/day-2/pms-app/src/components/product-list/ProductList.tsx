import { useState } from "react"
import type { Product } from "../../models/product"
import { products } from "../../data/products"
import './ProductList.css'

const ProductList = () => {
    const [productsState, setProductsState] = useState<Product[]>(products);
    const productTable = (
        <>
            <h2>List Of Products</h2>
            <table className="table table-hover">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody className="table-light">
                    {
                        productsState.map(
                            (p) => {
                                return <tr>
                                    <td>
                                        <img src={p.imageUrl} alt="NA" className="image-style" />
                                    </td>
                                    <td>{p.productName}</td>
                                    <td>{p.productPrice}</td>
                                </tr>
                            }
                        )
                    }
                </tbody>
            </table>
        </>
    )

    return productTable
}

export default ProductList