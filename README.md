<h1 align = "center">Java Dnevnik Ru Mobile API</h1>
<p align = "center">Оболочка для удобного использования <strong>мобильного</strong> API Дневника на Java</p>

**В стадии разработки...**

## Зависимости
- `Retrofit`
- `Gson`
- `RxJava3`
- `Lombok`

## Документация

Официальная документация **отсутствует**

## Использование

1. Добавьте в pom.xml:
```xml
<dependency>
    <groupId>io.github.alllexey123</groupId>
    <artifactId>dnevnik-mobile-api</artifactId>
    <version>1.1.0</version>
</dependency>
```
2. Создайте объект Dnevnik:
```java
Dnevnik dnevnik = Dnevnik.create();
```
3. Получение данных для использования API:
   * Передача токенов, айди пользователя и т.д. напрямую:
    ```java
    Credentials credentials = new Credentials();
    credentials.setUserId(12345L); // used in many methods
    credentials.setAccessToken("abc123"); // used in almost all methods
    ...
    dnevnik.getStorage().setCredentials(credentials);
    ```
   * Вход по логину/паролю Дневника:
    ```java
    dnevnik.getStorage().setCredentials(credentials);
    dnevnik.auth("my_cool_username", "my_strong_password")
        .blockingSubscribe(r -> {}, Throwable::printStackTrace);
    ```
   * Вход через Госуслуги:
    ```java
    dnevnik.getEsiaRegions()
        .flattenAsFlowable(EsiaRegionsResponse::getRegions)
        .map(region -> region.getRegionId() + " " + region.getName() + " " + region.getEsiaUrl())
        .blockingSubscribe(System.out::println, Throwable::printStackTrace); // print regions and their auth links
    ```
    Через полученную ссылку нужно войти в аккаунт Госуслуг в браузере (или в эмуляторе), а после использовать полученный taskId для входа:
    ```java
    String taskId = "123123-123123123-123123123-123123";
    int regionId = 123;

    dnevnik.esiaAuth(taskId, regionId)
        .blockingSubscribe(System.out::println, Throwable::printStackTrace);
    ```
4. Обновление контекста пользователя:
```java
dnevnik.updateUserContext()
    .blockingSubscribe(System.out::println, Throwable::printStackTrace); // print user context (example)
```
Обновление контекста необходимо для получения дополнительной информации о пользователе (группа, школа, личные данные и т.п.).
Многое из этого используется в других запросах к API.

5. Дальнейшее использование библиотеки:
Класс Dnevnik содержит в себе все реализованные методы API, в которые не надо передавать такие параметры, как userId, groupId, accessToken и т.д., они передаются из объекта Storage.
Можно создать свою реализацию Storage (например, хранить данные в БД).
Доступ к чистому API можно получить так:
```java
Dnevnik dnevnik = Dnevnik.create();
DnevnikApi api = dnevnik.api();
```
Взаимодействие с API реализовано благодаря RxJava3, все методы возвращают объект Single с результатом, либо исключение, которое можно обработать инструментами этой библиотеки.
Если объект, возвращённый API, наследуется от Restrictable, то поля в нём могут быть скрыты из-за отсутствия подписки (это может быть оценка, рейтинг и т.д.).

## Примеры

### Вывод среднего балла ученика по предметам за текущий период:
```java
// user context is required
dnevnik.getPeriodMarks(dnevnik.getStorage().getUserContext().getCurrentPeriod().getId())
    .flattenAsFlowable(PeriodMarksResponse::getPeriodMarks)
    .subscribe(finalMark -> {
        System.out.println(finalMark.getSubject().getName() + " " + finalMark.getAverageMarks().getAverageMark());
    }, Throwable::printStackTrace);
```
### Вывод последних оценок через получение фида:
```java
dnevnik.getUserFeed().flattenAsFlowable(FeedResponse::getRecentMarks)
    .map(FeedRecentMarkWrapper::getContent)
    .subscribe(recentMark -> {
        System.out.println(recentMark.getDate() + " " + recentMark.marksToString());
    }, Throwable::printStackTrace);
```
