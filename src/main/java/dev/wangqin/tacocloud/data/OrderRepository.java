package dev.wangqin.tacocloud.data;

import org.springframework.data.repository.CrudRepository;

import dev.wangqin.tacocloud.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
  /* `CurdRepository` already defines the methods you need, there's no need to explicitly define them.
   */
//  TacoOrder save(TacoOrder tacoOrder);
}
