package com.oracle.productapiservice;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class AppServiceBinder extends AbstractBinder{

	@Override
	protected void configure() {
		bind(ProductDao.class).to(new TypeLiteral<DaoContract<ProductDTO, Integer>>() {
		});
	}

}
