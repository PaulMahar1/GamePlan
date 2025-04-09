package com.example.gameplan.network

import com.google.gson.*
import java.lang.reflect.Type

class ObjectOrNullDeserializer<T>(
    private val clazz: Class<T>
) : JsonDeserializer<T?> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): T? {
        return if (json.isJsonObject) {
            Gson().fromJson(json, clazz)
        } else {
            null
        }
    }
}


// dont even ask...
// somethingsomething my singleplayergames list wanting to die because
// mackbookrequirements isnt always populated when retreiving game data...