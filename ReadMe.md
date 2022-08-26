# Kida

Unofficial Concurrent Kotlin Multiplatform NIDA API

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-linux] ![badge][badge-macos] ![badge][badge-android] ![badge][badge-ios] ![badge][badge-watchos] ![badge][badge-tvos] ![badge][badge-js] ![badge][badge-jvm]

![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=&logoColor=white)
![Swift](https://img.shields.io/badge/swift-F54A2A?style=for-the-badge&logo=swift&logoColor=white)
![iOS](https://img.shields.io/badge/iOS-000000?style=for-the-badge&logo=ios&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)

## Usage

```kotlin
val api: NidaApi = NidaApi()
api.info(nin = "19900101000000000001").then {
    println(it.name) // John Makongoro Doe
    println(it.dateOfBirth) // 1990-01-01
    // . . .
    println(it.nationality) // Tanzanian
}.catch {
    println("Oops!, Error: ${it.message}")
}
```

## Setup

```kotlin
dependencies {
    implementation("tz.co.asoft:kida-core:<version>")
}
```

## Coroutines Support

This api has been made in a non-blocking but still easily
usable from other platforms i.e.
Swift, Java and even Javascript/Typescript

It comes with a suspending method `await` that can be called in
suspend functions

```kotlin
val info = api.info(nin = "<nin-goes-here>").await() // << suspends on await
with(info) {
    println(name) // John Makongoro Doe
    println(dateOfBirth) // 1990-01-01
    // . . .
    println(nationality) // Tanzanian
}
```

## Testing

To make it easy to write tests for your logic,
we have integrated a NidaApiFake implementation

### Usage

```kotlin
val api: NidaApi = NidaApiFake()
api.info("19900101000000000001")
```

### Setup

Just add the `kida-fake` implementation on your tests

```kotlin
dependencies {
    implementation("tz.co.asoft:kida-fake:<version>")
}
```

### Test Subjects

You can use these two nin to test if you have everything wired up correctly

1. John Makongoro Doe (nin: 19900101000000000001)
2. Jane Makukuru Doe (nin: 19900101000000000002)

## Support

There are multiple ways you can support this project

### Start It

If you found it useful, just give it a star

### Contribute

You can help by submitting pull request to available open tickets on the issues section

### Report Issues

This makes it easier to catch bugs and offer enhancements required

## Credits

- [andylamax](https://github.com/andylamax) - The author
- [koncurrent-later](https://github.com/aSoft-Ltd/koncurrent/tree/main/later) - Non blocking kotlin multiplatform library
- [nida](https://github.com/Kalebu/Nida) - The python equivalent library
- [laravel-nida](https://github.com/alphaolomi/laravel-nida) The php equivalent library

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/kida-core/2?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-macos]: http://img.shields.io/badge/platform-macos-silver.svg?style=flat

[badge-linux]: http://img.shields.io/badge/platform-linux-green.svg?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat

[badge-ios]: http://img.shields.io/badge/platform-ios-silver.svg?style=flat

[badge-tvos]: http://img.shields.io/badge/platform-tvos-silver.svg?style=flat

[badge-watchos]: http://img.shields.io/badge/platform-watchos-silver.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat