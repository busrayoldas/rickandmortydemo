# rickandmortydemo

Demo uygulama için Rick And Morty çizgi filminin api'si seçilmiştir. Bu api hakkında genel bilgi için
GET - https://rickandmortyapi.com/api/ 
adresi kullanılabilir.

●	Java 11 kullanımıştır.
●	Uygulama Spring Boot ile yapılmıştır.
●	Uygulama Three-tier architecture (Katmanlı mimari) yapısına uygun tasarlanmıştır.
●   Collection Framework ile aşamalar gerçekleştirilmiştir.
●	Javadoc yazımına dikkat edilmiştir.
●	Geliştirilmiş olan demo uygulama dokümante edilmiştir.


1.	Modelleme 
	a.	GET - https://rickandmortyapi.com/api/   api yolu ile belirtilmiş olan adresten oluşacak bütün endpointlerin response tipleri modellenmiştir.

2.	Data hazırlık
	a.	Uygulama ayağa kalkarken aşağıdaki erişim bilgisi verilen adresler ile ilk datalar sisteme eklenmiştir.
		i.		https://rickandmortyapi.com/api/character
		ii.		https://rickandmortyapi.com/api/location
		iii.	https://rickandmortyapi.com/api/episode
	b.	Uygulama her başlatıldığında bu datalar yenilenmektedir.
	c.	Aşağıdaki yazılacak endpointler istek anında “rickandmortyapi” apisini tetikleyip gelen cevapları işlemeyecektir. Data hazırlık aşamasında hazırlanmış olan datalardan cevap vermiştir.

3.	RestFull WebService
	a.	Character
		i.	/character
			Yukarıda belirtildiği gibi bir endpoint açılmıştır. Sisteme kayıtlı tüm kayıtların listesini döner. 
			Sistemde istenilen sayfayı ve sayfada kaç veri geleceğini veren pagination yapısı bulunmaktadır.

		ii.	/character/{id}
			Yukarıda belirtildiği gibi bir endpoint açılmıştır. Sisteme kayıtlı tüm kayıtların listesini döner. 
			
	
	b.	Episode
		i.	/episode
			Yukarıda belirtildiği gibi bir endpoint açılmıştır. Sisteme kayıtlı tüm kayıtların listesini döner. 
			Sistemde istenilen sayfayı ve sayfada kaç veri geleceğini veren pagination yapısı bulunmaktadır.
			
		ii.	/episode/{id}
			Yukarıda belirtildiği gibi bir endpoint açılmıştır. Sisteme kayıtlı tüm kayıtların listesini döner. 
