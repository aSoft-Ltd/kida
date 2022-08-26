# Kida

Unofficial Kotlin Multiplatform NIDA API

## Usage

```kotlin
val api = NidaApi()
api.info(nin = "<nin-goes-here>")
```

## Setup

```kotlin
dependencies {
    implementation("tz.co.asoft:kida-core:0.0.1")
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
```

## Testing

To make it easy to write tests for your logic,
we have integrated a NidaApiFake implementation

### Usage

```kotlin
val api = NidaApiFake()
api.info("19900101000000000001")
```

### Setup

Just add the kida-fake implementation on your tests

```kotlin
dependencies {
    implementation("tz.co.asoft:kida-fake:0.0.1")
}
```

### Test Subjects

You can use these two nin to test if you have everything wired up correctly

1. John Makongoro Doe (nin: 19900101000000000001)
2. Jane Makukuru Doe (nin: 19900101000000000002)

## Support

There are multiple ways you can support this project

### Start It

If you found it useful, just give it a start

### Contribute

You can help by submitting pull request to available open tickets on the issues section

### Report Issues

This makes it easier to catch bugs and offer enhancements required

## Credits

- [andylamax](https://github.com/andylamax) - The author
- [koncurrent-later](https://github.com/aSoft-Ltd/koncurrent/tree/main/later) - Non blocking kotlin multiplatform library
- [nida](https://github.com/Kalebu/Nida) - The python equivalent library
- [laravel-nida](https://github.com/alphaolomi/laravel-nida) The php equivalent library