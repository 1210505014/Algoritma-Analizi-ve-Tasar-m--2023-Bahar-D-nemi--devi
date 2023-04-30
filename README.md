# Algoritma-Analizi-ve-Tasar-m--2023-Bahar-D-nemi--devi
GRAF Algoritmaları ve Uygulamaları

GRAF ALGORİTMALARI VE UYGULAMALARI

Hazırlayan: 
Adı: Gülbahar
Soyadı: Türüt
Öğrenci Numarası: 1210505014

GRAF TEORİSİ VE DİJKSTRA ALGORİTMASI

Graf Teorisi

Tarihçe:
Graf teorisi, matematiksel bir disiplindir ve 18. yüzyılın sonlarına doğru matematikçi Leonhard Euler tarafından geliştirilmiştir. Graf teorisi, nesnelerin birbirine bağlılıklarını analiz etmek için kullanılan bir matematik dalıdır. 
Euler, Königsberg köprüleri probleminin çözümü için graf teorisi kavramlarını geliştirdi. Bu problemde, Königsberg'deki yedi köprüden bir rota belirleyerek her köprüyü yalnızca bir kez geçmek istiyoruz. Euler, bu problemi çözmek için nesneleri noktalar ve köprüleri çizgiler olarak temsil etti ve böylece graf teorisi kavramlarını oluşturdu.
19. yüzyılda graf teorisi, bilimsel ve matematiksel araştırmalarda önemli bir araç haline geldi. Augustin-Louis Cauchy, daha karmaşık graf teorisi problemleri için matematiksel teoremler geliştirdi. Gustav Kirchhoff, elektrik devreleri için teoremler geliştirdi ve William R. Hamilton, graf teorisinin üzerinde çalıştığı en ünlü problemlerden biri olan Hamilton yolu problemine yönelik çalışmalar yaptı.
20. yüzyılda graf teorisi, bilgisayar bilimleri, iletişim ağları, biyoloji ve diğer disiplinlerde önemli bir rol oynamaya başladı. Graf teorisi, iletişim ağlarındaki veri transferinin optimizasyonunda, sosyal ağ analizinde, DNA dizileme ve protein-protein etkileşimleri gibi biyolojik sistemlerin analizinde, yol bulma problemlerinde, akış problemlerinde ve birçok diğer problemlerde kullanılır.
Graflar Nerelerde Kullanılır?
1.	İletişim ağları: Graf teorisi, iletişim ağlarının tasarımı, yönetimi ve optimizasyonunda kullanılır. Örneğin, internet gibi büyük ağlar, graf teorisi prensiplerine dayanır.
2.	Yol bulma problemleri: Graf teorisi, yol bulma problemlerinin çözümünde kullanılır. Bu tür problemler, örneğin, bir şehirdeki en kısa yol bulma, seyahat rotaları oluşturma ve trafik optimizasyonu gibi birçok farklı alanda kullanılabilir.
3.	Biyoloji: Graf teorisi, biyolojik sistemlerin analizinde kullanılır. Örneğin, protein-protein etkileşimleri, gen ekspresyonu ağları ve DNA dizileme gibi alanlarda graf teorisi kullanılır.
4.	Sosyal ağlar: Graf teorisi, sosyal ağların analizinde kullanılır. Örneğin, Facebook, Twitter gibi sosyal ağlar, graf teorisi prensiplerine dayanır.
5.	Matematik ve teorik bilgisayar bilimi: Graf teorisi, matematik ve teorik bilgisayar bilimi gibi disiplinlerde kullanılır. Örneğin, veri yapıları ve algoritmalar, graf teorisi kavramlarına dayanır.
6.	Fizik: Graf teorisi, bazı fizik problemlerinin analizinde kullanılır. Örneğin, manyetizma ve süperiletkenlik gibi alanlarda graf teorisi prensipleri uygulanabilir.
Bu, sadece graf teorisi kullanım alanlarının birkaç örneğidir. Graf teorisi, birçok farklı alanda kullanılan çok yönlü bir matematik dalıdır.

Grafların Genel Özellikleri:
1.	Düğüm sayısı: Bir grafın düğüm sayısı, grafın içerdiği toplam düğüm sayısını ifade eder.
2.	Kenar sayısı: Bir grafın kenar sayısı, grafın içerdiği toplam kenar sayısını ifade eder.
3.	Derece: Bir düğümün derecesi, düğüme bağlı olan kenar sayısını ifade eder.
4.	Açıklık: Grafın açıklığı, grafın düğümlerinin en yüksek derecesi ve en düşük derecesi arasındaki farktır.
5.	Topoloji: Bir grafın topolojisi, grafın düğümleri ve kenarları arasındaki bağlantıların nasıl düzenlendiğini ifade eder.
6.	Bağlantılılık: Bir grafın bağlantılığı, grafın bölünmeden önceki tek bir parça halinde olup olmadığını ifade eder.
7.	Çevre: Bir grafın çevresi, aynı düğümde başladığınızda bir tur boyunca takip edebileceğiniz kenarların dizisi olarak tanımlanır.
8.	Çap: Bir grafın çapı, grafın en uzak iki düğümü arasındaki en kısa yolun uzunluğunu ifade eder.
Bu, sadece graf özelliklerinden bazılarının birkaç örneğidir. Graf teorisinde birçok farklı özellik ve kavram vardır, her biri belirli bir problemin çözümünde farklı bir rol oynar.

Graf Çeşitleri:
1.	Basit graf: Yalnızca bir kez bağlantıya sahip olan çift sayısız düğüm ve kenarlardan oluşan bir graf türüdür.
2.	Yönlendirilmemiş graf: Kenarlarında yön bulunmayan, yalnızca düğümlerin birbirine bağlı olduğunu gösteren bir graf türüdür.
3.	Yönlendirilmiş graf: Kenarların yönü belirli olan, bir düğümün diğerine yön verdiği bir graf türüdür.
4.	Tam graf: Tüm düğümlerin birbirine doğrudan bağlı olduğu bir graf türüdür.
5.	Bipartit graf: Düğümler iki gruba ayrılan, ancak her iki grup arasındaki kenarlar yalnızca birbirinden farklı gruplardan düğümler arasında bulunan bir graf türüdür.
6.	Çoklu graf: Aynı iki düğüm arasında birden fazla kenarın bulunduğu bir graf türüdür.
7.	Ağırlıklı graf: Kenarlara farklı ağırlıklar atanan bir graf türüdür. Bu ağırlıklar, kenarların belirli bir özelliği veya mesafesi hakkında bilgi verir.
8.	İkili graf: Düğümlerin yalnızca iki düğüm arasındaki bağlantıyı temsil ettiği bir graf türüdür.
Bu, sadece graf teorisinde bulunan bazı graf türlerinin birkaç örneğidir. Graf teorisi, birçok farklı graf türüne sahiptir ve her tür, belirli bir problemin çözümü için farklı bir yaklaşım gerektirir.

Dijkstra Algoritması:
Dijkstra algoritması, tek kaynak en kısa yol problemi için kullanılan bir algoritmadır. Bu problem, bir graf içindeki bir düğümden diğer tüm düğümlere olan en kısa yolun bulunmasını hedefler. Örneğin, bir haritadaki iki nokta arasındaki en kısa yolun bulunması için kullanılabilir.
Dijkstra algoritması, bir graf içindeki düğümler arasındaki en kısa yolları bulmak için aşağıdaki adımları takip eder:
1.	Başlangıç düğümü seçilir ve diğer tüm düğümlere sonsuz mesafeler atanır.
2.	Başlangıç düğümünden diğer düğümlere olan mesafeler hesaplanır ve bu mesafeleri saklamak için bir mesafe tablosu oluşturulur.
3.	Başlangıç düğümünden diğer düğümlere olan mesafelere göre, henüz ziyaret edilmemiş en yakın düğüm seçilir ve ziyaret edilir.
4.	Ziyaret edilen düğüme komşu olan düğümlere yeni mesafeler hesaplanır. Bu mesafeler, ziyaret edilen düğüme olan mesafeden ve ziyaret edilen düğümün komşularına olan mesafeden oluşur. Eğer bu yeni mesafe, o düğüme daha önce hesaplanan mesafeden daha kısa ise, mesafe tablosu güncellenir.
5.	Tüm düğümler ziyaret edilene kadar 3. ve 4. adımlar tekrarlanır.
Dijkstra algoritması, en kısa yolları bulmak için etkili bir yöntemdir. Ancak, graf içindeki düğümler ve kenarlar sayısı arttıkça, hesaplama süresi de artabilir. Bu nedenle, büyük boyutlu graf problemlerinde kullanımı sınırlı olabilir.

MIND MAP ANALİZİ VE GEREKSİNİM DOKÜMANI
Yaptığım Algoritmanın Mind Map Analizi:
•	Başlangıç konumunu belirle.
•	Dijkstra algoritması kullanarak tüm konumlara olan en kısa mesafeyi hesapla.
•	Her konumdaki ihtiyaçları karşılayacak ürünleri seç.
•	Ürünleri başlangıç konumundan al.
•	İhtiyaç listesinden istenilen ürünleri en kısa konumdan seçilen konumlara dağıt.
•	Ürünleri teslim etmek istenen konumlara götür.
Yaptığım Algoritmanın Gereksinimleri:
1.	Programlama dili: Dijkstra algoritmasını ve Google Maps API'yi kullanmak için uygun bir programlama dili bilmek gereklidir. Bu algoritmada Java dili kullanılmıştır.
2.	Google Cloud hesabı: Google Maps API'yi kullanmak için bir Google Cloud hesabına ihtiyaç duyulur. 
3.	Konum verileri: Dijkstra algoritması ile konumlara göre en kısa yolu bulmak için konum verilerine ihtiyaç vardır. Bu veriler bir dosya veya veri tabanı şeklinde sağlanabilir.
4.	İhtiyaç listesi: Hangi ürünlere ihtiyaç duyulduğu ve her konumda ne kadar ihtiyaç olduğu belirtilen bir ihtiyaç listesi hazırlanmalıdır. İhtiyaçların öncelikleri ve stok bilgisi belirtilmelidir.
5.	Tedarikçi bilgileri: Listenin tedarik edileceği tedarikçinin bilgilerine ihtiyaç vardır. Bu bilgiler, bir dosya veya veri tabanı şeklinde sağlanabilir.
6.	Teslimat bilgileri: Ürünlerin teslim edileceği konumların adresleri ve diğer teslimat bilgileri hazır olmalıdır.
7.	Gerekli modüller: Dijkstra algoritması ve Google Maps API'yi kullanmak için gerekli modüllerin yüklü olması gerekir.

