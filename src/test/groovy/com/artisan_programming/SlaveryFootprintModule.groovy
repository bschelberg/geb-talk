package com.artisan_programming

import geb.Module

class SlaveryFootprintModule extends Module {
    static content = {
        question { $('#question_text') }
        nextButton { $('#next') }
        fineTuneBubble { $('#go_deeper_bs') }
        fineTuneClose { $('#fine_tune_close') }
    }
}
