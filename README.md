# VimeReplays
Плагин для записи и воспроизведения игр проекта [VimeWorld.ru](https://vimeworld.ru/). Цели проекта - высокая скорость,
максимальное сжатие записываемых данных и легкость в использовании.

## Использованные ресурсы
- **[Kryo (unsafe)](https://github.com/EsotericSoftware/kryo)** - используется для сериализации двоичных объектов Java.
- **[ZStandard (jni)](https://github.com/luben/zstd-jni)** - используется для сжатия записываемых данных.

## Использование
`VimeReplaysAPI.startRecording(gameName, gameType, mapName, players)` - начать запись игры.
- `gameName` - название игры;
- `gameType` - тип игры;
- `mapName` - карта игры;
- `players` - начальные игроки для записи их движения.

`VimeReplaysAPI.stopRecording()` - остановить запись игры.

`VimeReplaysAPI.removeRecordablePlayer(player)` - удалить записываемого игрока (уже зрителя).
- `player` - игрок записываемой игры.