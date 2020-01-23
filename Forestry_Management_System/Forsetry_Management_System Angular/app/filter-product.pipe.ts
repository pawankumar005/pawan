import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterProduct'
})
export class FilterProductPipe implements PipeTransform {

  transform(products: Products[], search: string ): Products[] {
    if(search === undefined ){
      return products;
    } else{
      return products.filter((product, index ) => {
        return product.productName.toLocaleLowerCase().includes(search.toLocaleLowerCase())
      });
    }
  }

}
