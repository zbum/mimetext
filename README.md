# mime text command - java native (graalvm)
* support mimetext encode/decode
```shell
$ mimetext -e '가나다라'
=?utf-8?B?6rCA64KY64uk6528?=
$ mimetext -d '=?utf-8?B?6rCA64KY64uk6528?='
가나다라
```

## build
* install GraalVM with SdkMan
```shell
$ sdk install java 21.0.0.2.r11-grl
```
* build
```shell
$ ./build.sh
```

