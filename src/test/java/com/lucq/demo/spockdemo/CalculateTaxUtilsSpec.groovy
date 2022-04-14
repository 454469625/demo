package com.lucq.demo.spockdemo

import spock.lang.Specification
import spock.lang.Unroll

class CalculateTaxUtilsSpec extends Specification {
    @Unroll
    def "个税计算，收入：#income, 个税，#result"() {
        expect: "when + then 的组合"
        Demo1.calc(income) == result

        where: "表格方式测试不同的分支逻辑"
        income || result
        -1     || 0
        0      || 0
        2999   || 89.97
        3000   || 90.0
        3001   || 90.1
        11999  || 989.9
    }
}
