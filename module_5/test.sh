#!/usr/bin/env sh

export test_file="${1:?test.sh needs input tests}"

run_tests() {
    while read -r line; do
        # Skip blank lines
        [ -z "$line" ] && continue
        case "$line" in
            \#*)
                count=$((count+1))
                test_case="${line#*:}"
                echo "----- RUNNING TEST $count:$test_case -----"
                ;;
            *)
                echo "TEST INPUT: '$line'"
                printf '%s\n\0' "$line" | java com.csc320.module_5.WeeklyTemps
                echo ""
                ;;
        esac
    done < "$test_file"
}

main() {
    run_tests
}

main "$@"
