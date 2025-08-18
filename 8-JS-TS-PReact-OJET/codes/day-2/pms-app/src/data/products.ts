import type { Product } from "../models/product";

export const products: Product[] = [
    {
        productId: 100,
        productName: 'dell xps 15',
        productDescription: 'new 15 inch laptop from dell',
        productPrice: 120000,
        productReleasedOn: new Date(2024, 10, 7),
        categoryId: 1,
        imageUrl: 'https://shorturl.at/EoqOj'
    },
    {
        productId: 101,
        productName: 'iPhone 16',
        productDescription: 'new mobile from apple',
        productPrice: 85000,
        productReleasedOn: new Date(2024, 11, 8),
        categoryId: 2,
        imageUrl: 'https://shorturl.at/sPk4Q'
    }
];