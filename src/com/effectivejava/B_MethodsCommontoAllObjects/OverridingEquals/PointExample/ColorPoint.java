package com.effectivejava.B_MethodsCommontoAllObjects.OverridingEquals.PointExample;

public class ColorPoint extends Point {
    //Burada ColorPoint Point'i extend ediyor ve equals'i override ediyor
    private final Color color;

    public ColorPoint(int x, int y,Color color) {
        super(x, y);
        this.color=color;
    }

//    @Override
//    public boolean equals(Object o){
//        if(!(o instanceof ColorPoint))
//            return false;
//        //Bu durumda symmetry (simertri)  bozuluyor. Bu ne demek,aynı x ve ye değerleri taşıyan,
//        // Point ile Colorpoint'i kıyaslarken true, ColorPoint ile
//        // Point'i kıyaslarken false alırız.
//        return super.equals(o) && ((ColorPoint) o).color==color;
//    }
//
//    /**
//     * Bu durumu düzeltmek için renksiz noktalar için kıyaslama yapan bir if kontrol yapısı araya koyabiliriz.
//     *
//     *
//     */
//
//    @Override
//    public boolean equals(Object o){
//        //eğer bu sınıfla kıyaslanan nesne Point değilse (ki ColorPoint'de Point)
//        if(!(o instanceof Point))
//            return false;
//
//        // burada eğer nesnemiz normal Point ise Point sınıfı ile kıyaslama yapıyoruz.
    // //tip kontrolü yapmak için instanceof kullanın
//        if(!(o instanceof ColorPoint))
//            return o.equals(this); // Normal point olan nesne ile bu sınıfı kıyasla yani yalnızca x,y kıyaslanacak.
//
//        //eğer point ColorPoint ise:
//        return super.equals(o) && ((ColorPoint) o).color==color;
//        // bu durumda transitivity: bozuyoruz.
//        // ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
//        // Point p2 = new Point(1, 2);
//        // ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
//        // durumunda p1.equals(p2) true ve p2.equals(p3) true olmasına rağmen p1.equals(p3) false dönmektedir. Color:RED == Color.BLUE
//
//    }

    @Override
    public boolean equals(Object obj){
        //yukarıda karşılaşılan iki problemin aynı anda çözümü
        if(obj == null || obj.getClass() != getClass())
            //equals methodunun içinde null check olmasına dikkat ediniz
            // bunu yaparken (!(obj instance of Point)) şeklinde yaparsak obj==null şeklinde kontrol etmemize gerek yoktur
            //ilk check obj'nin null olup olmadığını kontrol eder instance of daki.
            return false;
        Point p=(Point) obj;
        // argümanları kontrol etmek için == operatörünü kullanın
        return p.x == x && p.y ==y;
        //fakat bu çözümde LSP prensibini ihlal ediyoruz. Eğer Point nesnesini extend edersek bu extend ettiğimiz sınıf için
        //geçerli olmayacak.
    }


}
