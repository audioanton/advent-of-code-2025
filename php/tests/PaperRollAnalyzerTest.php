<?php

declare(strict_types=1);

namespace Tests;

use App\day_4\PaperRollAnalyzer;


describe('PaperRollAnalyzer', function () {

    it('returns 13', function () {
        $analyzer = new PaperRollAnalyzer();

        $result = $analyzer->analyze([
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
          ]
        );

        expect($result)->toBe(13);
    });

    it("parses new lines", function () {
        $analyzer = new PaperRollAnalyzer();

        $expected = [
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@.",
                "@@.@@@@.@@",
                ".@@@@@@@.@",
                ".@.@.@.@@@",
                "@.@@@.@@@@",
                ".@@@@@@@@.",
                "@.@.@@@.@."
        ];

        $result = $analyzer->parse(
            "..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."
        );

        expect($result)->toEqual($expected);
    });

    it("parses from file", function () {

        $fileString = file_get_contents("src/day_4/input");

        $analyzer = new PaperRollAnalyzer();

        $result = $analyzer->parse($fileString);

        expect(count($result))->toBeGreaterThan(1);
        expect($result[0])->toEqual("@.@.@@@@@@@..@@@.@@.@.@..@@.@.@@@....@.@@@@.@@@@@@.@@.@@@..@..@.@@.@@@@@@@.@...@@@@@@....@@@@@@@.....@.@..@...@@.@@@@@@@@@.@@@..@@@.@..@@@@");
        expect($result[1])->toEqual("@@@..@@@@@@@@..@@@.@@@.@@@@.@@@@@.@.@@@@@.@@......@.@.@@...@@@@.@@.@@.@@@@@@.@@@.@..@@@@@@@@@@@@@@@.@.@@@.@@@.@.@@@....@@@@@.@.@..@.@...@.@");

        expect($result[array_key_last($result)])->toEqual(".@@@@.@@..@....@@@..@@.@@@@@@@.@..@@@@@@@.@.@@....@@.@@@.@@...@..@@.@.@.@@.@@@.@@@@@@@@@@@......@..@..@@@@.@@.@.@@@@@@@@@@@@@.@.@@..@@@..@.");
    });
});
