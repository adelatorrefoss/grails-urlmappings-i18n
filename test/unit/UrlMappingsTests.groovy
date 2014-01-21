@TestFor(UrlMappings)
@Mock([Test1Controller, Test2Controller])
class UrlMappingsTests {
    void testUrlMappings() {

        // ['es','en']
        // assertForwardUrlMapping("/nameA_es", controller: 'test1', action: "action1")
        // assertForwardUrlMapping("/nameA_en", controller: 'test1', action: "action1")

        // assertForwardUrlMapping("/nameB", controller: 'test2', action: "action2")

        // shouldFail {
        //     assertForwardUrlMapping("/action2", controller: 'test1', action: "action1")
        // }
    }
}
