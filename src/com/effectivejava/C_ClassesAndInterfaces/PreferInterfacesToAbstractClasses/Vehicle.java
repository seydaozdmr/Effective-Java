package com.effectivejava.C_ClassesAndInterfaces.PreferInterfacesToAbstractClasses;

public abstract class Vehicle {
     /**
     *abstract sınıf ve interface, java 8'den sonra interface içinde default method tanımlayabildiğimiz için
      * her iki mekanizma da instance method uygulamamıza olanak sağlamıştır, arasında en temel farklılık; bir abstract
      * sınıfda tanımlanan implementasyonu uygulamak için sınıfın o abstract sınıfın alt sınıfı olması zorunluluğudur.
      * Java yalnızca bir sınıftan extend edilebilmesi şeklinde kısıtlama getirdiği için bu durum aynı zamanda tür tanımı
      * olarak abstract sınıfı kısıtlamıştır. Bunun yanında gerekli tüm methodları tanımlayan ve genel sözleşmeye uyan herhangi
      * bir sınıfın, sınıf hiyerarşisine bakılmadan interface'i implemente etmesine izin verilir ve o tipi gerçekleştirmiş olur.
      *
      * Existing classes can easily be retrofitted to implement a new interface.Existing classes cannot, in
      * general, be retrofitted to extend a new abstract class. If you want to have two
      * classes extend the same abstract class, you have to place it high up in the type
      * hierarchy where it is an ancestor of both classes.
      *
      * Unfortunately, this can cause
      * great collateral damage to the type hierarchy, forcing all descendants of the new
      * abstract class to subclass it, whether or not it is appropriate.
     */


}
