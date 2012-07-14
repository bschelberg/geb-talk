package com.artisan_programming

class SlaveryFootprintSportingPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('What About Sporting Goods?'); true }
    static content = {
        common { module SlaveryFootprintModule }

        baseball { $('#baseball_canvas') }
        football { $('#americanfootball_canvas') }
        cycling { $('#cycling_canvas') }
        soccer { $('#football_canvas') }
        skiing { $('#skiing_canvas') }
        camping { $('#camping_canvas') }
        running { $('#running_canvas') }
        snowboarding { $('#snowboarding_canvas') }
        golf { $('#golf_canvas') }
        snorkelling { $('#snorkling_canvas') }
        surfing { $('#surfing_canvas') }
        waterskiing { $('#waterskiing_canvas') }
        fishing { $('#fishing_canvas') }
        snowwalking { $('#snowwalking') }
    }
}
