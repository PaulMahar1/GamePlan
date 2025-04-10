package com.example.gameplan.data

import com.google.gson.annotations.SerializedName

typealias GameInfo = Map<String, GameTwo>

data class GameTwo(
    @SerializedName("data")
    val data: GameData?,
    @SerializedName("success")
    val success: Boolean?
)

data class GameData(
    @SerializedName("about_the_game")
    val aboutTheGame: String? = null,
    @SerializedName("achievements")
    val achievements: Achievements? = null,
    @SerializedName("background")
    val background: String? = null,
    @SerializedName("background_raw")
    val backgroundRaw: String? = null,
    @SerializedName("capsule_image")
    val capsuleImage: String? = null,
    @SerializedName("capsule_imagev5")
    val capsuleImagev5: String? = null,
    @SerializedName("categories")
    val categories: List<Category?>? = emptyList(),
    @SerializedName("content_descriptors")
    val contentDescriptors: ContentDescriptors? = null,
    @SerializedName("controller_support")
    val controllerSupport: String? = null,
    @SerializedName("detailed_description")
    val detailedDescription: String? = null,
    @SerializedName("developers")
    val developers: List<String?>? = emptyList(),
    @SerializedName("dlc")
    val dlc: List<Int?>? = emptyList(),
    @SerializedName("genres")
    val genres: List<Genre?>? = emptyList(),
    @SerializedName("header_image")
    val headerImage: String? = null,
    @SerializedName("is_free")
    val isFree: Boolean? = false,
    @SerializedName("linux_requirements")
    val linuxRequirements: LinuxRequirements? = null,
    @SerializedName("mac_requirements")
    val macRequirements: MacRequirements? = null,
    @SerializedName("metacritic")
    val metacritic: Metacritic? = null,
    @SerializedName("movies")
    val movies: List<Movy?>? = emptyList(),
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("package_groups")
    val packageGroups: List<PackageGroup?>? = emptyList(),
    @SerializedName("packages")
    val packages: List<Int?>? = emptyList(),
    @SerializedName("pc_requirements")
    val pcRequirements: PcRequirements? = null,
    @SerializedName("platforms")
    val platforms: Platforms? = null,
    @SerializedName("price_overview")
    val priceOverview: PriceOverview? = null,
    @SerializedName("publishers")
    val publishers: List<String?>? = emptyList(),
    @SerializedName("ratings")
    val ratings: Ratings? = null,
    @SerializedName("recommendations")
    val recommendations: Recommendations? = null,
    @SerializedName("release_date")
    val releaseDate: ReleaseDate? = null,
    @SerializedName("required_age")
    val requiredAge: Int? = 0,
    @SerializedName("reviews")
    val reviews: String? = null,
    @SerializedName("screenshots")
    val screenshots: List<Screenshot?>? = emptyList(),
    @SerializedName("short_description")
    val shortDescription: String? = null,
    @SerializedName("steam_appid")
    val steamAppid: Int? = null,
    @SerializedName("support_info")
    val supportInfo: SupportInfo? = null,
    @SerializedName("supported_languages")
    val supportedLanguages: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("website")
    val website: String? = null
)


data class Achievements(
    @SerializedName("highlighted")
    val highlighted: List<Highlighted?>?,
    @SerializedName("total")
    val total: Int?
)

data class Category(
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int?
)

data class ContentDescriptors(
    @SerializedName("ids")
    val ids: List<Any?>?,
    @SerializedName("notes")
    val notes: Any?
)

data class Genre(
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?
)

data class LinuxRequirements(
    @SerializedName("minimum")
    val minimum: String?
)

data class MacRequirements(
    @SerializedName("minimum")
    val minimum: String?
)

data class Metacritic(
    @SerializedName("score")
    val score: Int?,
    @SerializedName("url")
    val url: String?
)

data class Movy(
    @SerializedName("highlight")
    val highlight: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("mp4")
    val mp4: Mp4?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("webm")
    val webm: Webm?
)

data class PackageGroup(
    @SerializedName("description")
    val description: String?,
    @SerializedName("display_type")
    val displayType: Int?,
    @SerializedName("is_recurring_subscription")
    val isRecurringSubscription: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("save_text")
    val saveText: String?,
    @SerializedName("selection_text")
    val selectionText: String?,
    @SerializedName("subs")
    val subs: List<Sub?>?,
    @SerializedName("title")
    val title: String?
)

data class PcRequirements(
    @SerializedName("minimum")
    val minimum: String?
)

data class Platforms(
    @SerializedName("linux")
    val linux: Boolean?,
    @SerializedName("mac")
    val mac: Boolean?,
    @SerializedName("windows")
    val windows: Boolean?
)

data class PriceOverview(
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("discount_percent")
    val discountPercent: Int?,
    @SerializedName("final")
    val `final`: Int?,
    @SerializedName("final_formatted")
    val finalFormatted: String?,
    @SerializedName("initial")
    val initial: Int?,
    @SerializedName("initial_formatted")
    val initialFormatted: String?
)

data class Ratings(
    @SerializedName("dejus")
    val dejus: Dejus?,
    @SerializedName("esrb")
    val esrb: Esrb?,
    @SerializedName("steam_germany")
    val steamGermany: SteamGermany?
)

data class Recommendations(
    @SerializedName("total")
    val total: Int?
)

data class ReleaseDate(
    @SerializedName("coming_soon")
    val comingSoon: Boolean?,
    @SerializedName("date")
    val date: String?
)

data class Screenshot(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("path_full")
    val pathFull: String?,
    @SerializedName("path_thumbnail")
    val pathThumbnail: String?
)

data class SupportInfo(
    @SerializedName("email")
    val email: String?,
    @SerializedName("url")
    val url: String?
)

data class Highlighted(
    @SerializedName("name")
    val name: String?,
    @SerializedName("path")
    val path: String?
)

data class Mp4(
    @SerializedName("max")
    val max: String?,
    @SerializedName("480")
    val x480: String?
)

data class Webm(
    @SerializedName("max")
    val max: String?,
    @SerializedName("480")
    val x480: String?
)

data class Sub(
    @SerializedName("can_get_free_license")
    val canGetFreeLicense: String?,
    @SerializedName("is_free_license")
    val isFreeLicense: Boolean?,
    @SerializedName("option_description")
    val optionDescription: String?,
    @SerializedName("option_text")
    val optionText: String?,
    @SerializedName("packageid")
    val packageid: Int?,
    @SerializedName("percent_savings")
    val percentSavings: Int?,
    @SerializedName("percent_savings_text")
    val percentSavingsText: String?,
    @SerializedName("price_in_cents_with_discount")
    val priceInCentsWithDiscount: Int?
)

data class Dejus(
    @SerializedName("banned")
    val banned: String?,
    @SerializedName("descriptors")
    val descriptors: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("rating_generated")
    val ratingGenerated: String?,
    @SerializedName("required_age")
    val requiredAge: String?,
    @SerializedName("use_age_gate")
    val useAgeGate: String?
)

data class Esrb(
    @SerializedName("descriptors")
    val descriptors: String?,
    @SerializedName("display_online_notice")
    val displayOnlineNotice: String?,
    @SerializedName("rating")
    val rating: String?
)

data class SteamGermany(
    @SerializedName("banned")
    val banned: String?,
    @SerializedName("descriptors")
    val descriptors: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("rating_generated")
    val ratingGenerated: String?,
    @SerializedName("required_age")
    val requiredAge: String?,
    @SerializedName("use_age_gate")
    val useAgeGate: String?
)


