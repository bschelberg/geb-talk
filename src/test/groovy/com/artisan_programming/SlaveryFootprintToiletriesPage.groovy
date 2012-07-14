package com.artisan_programming

class SlaveryFootprintToiletriesPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('Let\'s Take a Peek in Your Medicine Cabinet'); true }
    static content = {
        common { module SlaveryFootprintModule }

        shelfItems { $('#shelves .shelve_item') }
        shavingCream { $('#shaving_cream') }
        sunscreen { $('#sunscreen') }
        moisturizer { $('#moisturizer') }
        dentalFloss { $('#dental_floss') }
        mouthwash { $('#mouthwash') }
        toothpaste { $('#toothpaste') }
        toothbrush { $('#toothbrush') }
        lipGloss { $('#lip_gloss') }
        mascara { $('#mascara') }
        concealer { $('#concealer') }
        foundation { $('#foundation') }
        bronzer { $('#bronzer') }
        eyePencil { $('#eye_pencil') }
        lipStick { $('#lip_stick') }
        blush { $('#blush') }
        nailPolishRemover { $('#nail_polish_remover') }
        handSanitizer { $('#hand_sanitizer') }
        soap { $('#soap') }
        conditioner { $('#conditioner') }
        bodyWash { $('#body_wash') }
        hairbrush { $('#hair_brush') }
        aspirin { $('#aspirin') }
        contactLenses { $('#contact_lenses') }
        womensFragrance { $('#womens_fragrance') }
        deodorant { $('#deodorant') }
    }

    void selectToiletries(List toiletries) {
        shelfItems.each { shelfItem ->
            if (toiletries.find { it.@id == shelfItem.@id }) {
                if (shelfItem.classes().find { it =~ /^medicine_cabinet_off-.+/ }) {
                    shelfItem.click()
                }
            } else {
                if (!shelfItem.classes().find { it =~ /^medicine_cabinet_off-.+/ }) {
                    shelfItem.click()
                }
            }
        }
    }
}
