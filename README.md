# simple-insurace-app

Projede Java 11 ve Maven 3.6.3 versiyonları kullanılmıştır.

Database olarak H2 database kullanılmıştır.(in-memory)

**************************

Projedeki API tasarımları şu şekildedir:

Yeni kampanya oluşturmak için:

POST: ```/api/campaigns```

``` 
CampaignInput{
  "campaignCategory": enum; notNull, (TSS, OSS, HS, OTHER)
  "description": string; notNull, (20-200 char)
  "name": string; notNull,unique, (10-50 char)
}
```

Bütün kampanyaları görüntülemek için:

GET: ```api/campaigns```

Bir kampanyayı görüntülemek için:

GET: ```/api/campaigns/{id}```

Bir kampanyayı silmek için:

DELETE: ```/api/campaigns/{id}```

Durumu PENDING olan kampanyayı ACTIVE'e çevirmek için:

PATCH: ```/api/campaigns/{id}/approve```

Durumu PENDING veya ACTIVE olan kampanyayı NOT_ACTIVE'e çevirmek için:

PATCH: ```/api/campaigns/{id}/deactivate```

Bütün kampanyaların durumlarına göre istatistiklerini görüntülemek için:

GET: ```/api/campaigns/classified-stats```

*************************

Proje başarılı bir şekilde çalıştıktan sonra

Database'e bağlanmak için: http://localhost:8080/h2

Swagger dökümantasyonuna erişmek için: http://localhost:8080/swagger-ui/index.html
