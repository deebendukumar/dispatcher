from fastapi import APIRouter

from api.v1.endpoints import (brands, 
                              categories, 
                              attributes, 
                              dimensions, 
                              products, 
                              variants)

api_router = APIRouter();

api_router.include_router(brands.router, prefix="/brands", tags=["brands"])
api_router.include_router(categories.router, prefix="/categories", tags=["categories"])
api_router.include_router(attributes.router, prefix="/attributes", tags=["attributes"])
api_router.include_router(dimensions.router, prefix="/dimensions", tags=["dimensions"])
api_router.include_router(products.router, prefix="/products", tags=["products"])
api_router.include_router(variants.router, prefix="/variants", tags=["variants"])