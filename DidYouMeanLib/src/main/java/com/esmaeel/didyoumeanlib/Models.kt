package com.esmaeel.didyoumeanlib

data class ErMod(
    val error: Error? = Error()
) {
    data class Error(
        val code: Int? = 400,
        val message: String? = "API key not valid. Please pass a valid API key."
    )
}


data class SpellObject(
    val context: Context? = Context(),
    val items: List<Item?>? = listOf(),
    val kind: String? = "",
    val queries: Queries? = Queries(),
    val searchInformation: SearchInformation? = SearchInformation(),
    val spelling: Spelling? = Spelling(),
    val url: Url? = Url()
) {
    data class Context(
        val facets: List<List<Facet?>?>? = listOf(),
        val title: String? = ""
    ) {
        data class Facet(
            val anchor: String? = "",
            val label: String? = "",
            val label_with_op: String? = ""
        )
    }

    data class Item(
        val cacheId: String? = "",
        val displayLink: String? = "",
        val fileFormat: String? = "",
        val formattedUrl: String? = "",
        val htmlFormattedUrl: String? = "",
        val htmlSnippet: String? = "",
        val htmlTitle: String? = "",
        val kind: String? = "",
        val labels: List<Label?>? = listOf(),
        val link: String? = "",
        val mime: String? = "",
        val snippet: String? = "",
        val title: String? = ""
    ) {
        data class Label(
            val displayName: String? = "",
            val label_with_op: String? = "",
            val name: String? = ""
        )
    }

    data class Queries(
        val request: List<Request?>? = listOf()
    ) {
        data class Request(
            val count: Int? = 0,
            val cx: String? = "",
            val inputEncoding: String? = "",
            val outputEncoding: String? = "",
            val safe: String? = "",
            val searchTerms: String? = "",
            val startIndex: Int? = 0,
            val title: String? = "",
            val totalResults: String? = ""
        )
    }

    data class SearchInformation(
        val formattedSearchTime: String? = "",
        val formattedTotalResults: String? = "",
        val searchTime: Double? = 0.0,
        val totalResults: String? = ""
    )

    data class Spelling(
        val correctedQuery: String? = null,
        val htmlCorrectedQuery: String? = ""
    )

    data class Url(
        val template: String? = "",
        val type: String? = ""
    )
}